import React, { useEffect, useState } from "react";

function Historico() {

    const [historico, setHistorico] = useState([]);
    const [ano, setAno] = useState("");
    const [modelo, setModelo] = useState("");
    const [pagina, setPagina] = useState(0);
    const [totalPaginas, setTotalPaginas] = useState(0);

    const fetchHistorico = () => {
        let url = `https://calculo-imposto-77b79255db57.herokuapp.com/api/historico?page=${pagina}&size=5`;

        if (ano) url += `&ano=${ano}`;
        if (modelo) url += `&modelo=${modelo}`;

        fetch(url).then
            (res => res.json()).then
            (data => {
                setHistorico(data.content);
                setTotalPaginas(data.totalPages);
            }).catch
            (err => console.error("Erro ao buscar histórico:", err));
    };

    useEffect(() => {
        fetchHistorico();
    }, [pagina]);

    return (
        <div style={{ marginTop: "30px" }}>
            <h2>Histórico de Cálculos</h2>
            <div style={{ marginBottom: "15px" }}>
                <label>
                    Ano:&nbsp;
                    <select value={ano} onChange={(e) => setAno(e.target.value)}>
                        <option value="">Todos</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                    </select>
                </label>
                &nbsp;&nbsp;
                <label>
                    Modelo:&nbsp;
                    <select value={modelo} onChange={(e) => setModelo(e.target.value)}>
                        <option value="">Todos</option>
                        <option value="Simplificado">Simplificado</option>
                        <option value="Completo">Completo</option>

                    </select>
                </label>
                &nbsp;&nbsp;
                <button onClick={fetchHistorico}>Filtrar</button>
            </div>
            <table border="1" cellPadding="5">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Ano</th>
                        <th>Renda</th>
                        <th>Dependentes</th>
                        <th>Despesa com Instrução</th>
                        <th>Modelo</th>
                        <th>Base</th>
                        <th>Imposto</th>
                    </tr>
                </thead>
                <tbody>
                    {historico.map((item) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.ano}</td>
                            <td>R$ {item.rendaAnual.toFixed(2)}</td>
                            <td>{item.dependentes}</td>
                            <td>R$ {item.despesasInstrucao.toFixed(2)}</td>
                            <td>{item.modelo}</td>
                            <td>R$ {item.baseCalculo.toFixed(2)}</td>
                            <td>R$ {item.imposto.toFixed(2)}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div style={{marginTop: "10px"}}>
                <button onClick={() => setPagina(pagina - 1)} disabled={pagina === 0}>
                    Anterior
                </button>
                &nbsp; Página {pagina + 1} de {totalPaginas} &nbsp;
                <button onClick={() => setPagina(pagina + 1)} disabled={pagina +1 >= totalPaginas}>
                    Próxima
                </button>
            </div>
        </div>
    );

}

export default Historico;
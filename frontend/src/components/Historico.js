import React, { useEffect, useState } from "react";

function Historico() {

    const [historico, setHistorico] = useState([]);
    const [ano, setAno] = useState("");
    const [modelo, setModelo] = useState("");

    const fetchHistorico = () => {
        let url = "https://calculo-imposto-77b79255db57.herokuapp.com/api/historico";
        const params = [];

        if (ano) params.push('ano=${ano}');
        if (modelo) params.push('modelo=${modelo}');
        if (params.length) url += "?" + params.join("&");

        fetch(url).then
            (res => res.json()).then
            (data => setHistorico(data)).catch
            (err => console.error("Erro ao buscar histórico:", err));
    };

    useEffect(() => {
        fetchHistorico();
    }, []);

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
                        <th>Educação</th>
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
        </div>
    );

}

export default Historico;
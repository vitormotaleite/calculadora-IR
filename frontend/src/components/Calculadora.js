import React, { useState } from "react";
import "./Styles.css"

function Calculadora() {
  const [form, setForm] = useState({
    ano: 2025,
    rendaAnual: "",
    dependentes: "",
    despesasInstrucao: "",
    simplificado: false,
  });

  const [resultado, setResultado] = useState(null);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setForm({
      ...form,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("token");
    const response = await fetch("https://calculo-imposto-77b79255db57.herokuapp.com/api/imposto", {
      method: "POST",
      headers: { "Content-Type": "application/json", Authorization: `Bearer ${token}`, },
      body: JSON.stringify({
        ...form,
        rendaAnual: parseFloat(form.rendaAnual),
        dependentes: parseInt(form.dependentes),
        despesasInstrucao: parseFloat(form.despesasInstrucao),
      }),
    });

    if (!response.ok) {
      const errorText = await response.text(); // captura a resposta, mesmo se não for JSON
      console.error("Erro:", errorText);
      alert("Erro: " + response.status + " - " + errorText);
      return;
    }

    const data = await response.json();
    setResultado(data);
  };

  return (
    <div className="container">
      <h1>Calculadora Imposto de Renda</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Ano:
          <select name="ano" value={form.ano} onChange={handleChange}>
            <option value={2025}>2025</option>
            <option value={2024}>2024</option>
            <option value={2026}>2026</option>
          </select>
        </label>

        <label>
          Renda Anual:
          <input
            type="number"
            name="rendaAnual"
            value={form.rendaAnual}
            onChange={handleChange}
            required
          />
        </label>

        <label>
          Dependentes:
          <input
            type="number"
            name="dependentes"
            value={form.dependentes}
            onChange={handleChange}
            required
          />
        </label>

        <label>
          Despesas com Instrução:
          <input
            type="number"
            name="despesasInstrucao"
            value={form.despesasInstrucao}
            onChange={handleChange}
            required
          />
        </label>

        <label className="checkbox">
          <input
            type="checkbox"
            name="simplificado"
            checked={form.simplificado}
            onChange={handleChange}
          />
          Utilizar Modelo simplificado
        </label>

        <button type="submit">Calcular</button>
      </form>

      {resultado && (
        <div className="resultado">
          <h2>Resultado:</h2>
          <p>Base de Cálculo: R$ {resultado.baseCalculo.toFixed(2)}</p>
          <p>Imposto: R$ {resultado.imposto.toFixed(2)}</p>
          <p>Modelo: {resultado.modelo}</p>
        </div>
      )}
    </div>
  );
}

export default Calculadora;
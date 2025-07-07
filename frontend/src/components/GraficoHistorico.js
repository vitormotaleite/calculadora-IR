import React from "react";
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from "recharts";

function GraficoHistorico({ dados }) {
    if (!dados || dados.length === 0) {
        <p style={{marginTop:"20px"}}>Nenhum dado para exibir.</p>;
    }
    return (
        <div style={{ marginTop: "40px" }}>
            <h2>Gráfico: Imposto por Cálculo</h2>
            <ResponsiveContainer width="100%" height={300}>
                <BarChart data={dados}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="id" />
                    <YAxis />
                    <Tooltip formatter={(value) => `R$ ${value}`} />
                    <Legend />
                    <Bar dataKey="imposto" fill="#8884d8" name="Imposto" />
                    <Bar dataKey="baseCalculo" fill="#82ca9d" name="Base de Cálculo" />
                </BarChart>
            </ResponsiveContainer>
        </div>
    );
}

export default GraficoHistorico;
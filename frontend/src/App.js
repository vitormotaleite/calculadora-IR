import React, {useState} from "react";
import "./Styles.css"

function App() {
  const [form, setForm] = useState({
    ano: 2025,
    rendaAnual: "",
    dependentes: "",
    despesasInstrucao: "",
    simplificado: false,
  });

  const [resultado, setResultado] = useState(null);

  const handleChange = (e) => {
    const {name, value, type, checked} = e.target;
    setForm({
      ...form,
      [name]: type === "checkbox" ? checked : value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await fetch("")
  }
}
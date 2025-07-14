import React, { useState } from "react";

function Login({ onLogin }) {
    const [form, setForm] = useState({ username: "", password: "" });
    const [erro, setErro] = useState("");

    const handleChange = (e) => {
        const { name, value } = e.target;
        setForm({ ...form, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setErro("");

        try {
            const response = await fetch("https://calculo-imposto-77b79255db57.herokuapp.com/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(form),
            });

            if (!response.ok) throw new Error("Credenciais inválidas");

            const data = await response.json();
            localStorage.setItem("token", data.token);
            onLogin();
            console.log("Token:", localStorage.getItem("token"));
        } catch (err) {
            setErro(err.message);
        }
    };

    return (
        <div style={{ margin: "40px" }}>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Usuário:
                    <input
                        type="text"
                        name="username"
                        value={form.username}
                        onChange={handleChange}
                        required
                    />
                </label>
                <br />
                <label>
                    Senha:
                    <input
                        type="password"
                        name="password"
                        value={form.password}
                        onChange={handleChange}
                        required
                    />
                </label>
                <br />
                <button type="submit">Entrar</button>
            </form>
            {erro && <p style={{ color: "red" }}>{erro}</p>}
        </div>
    );
}

export default Login;
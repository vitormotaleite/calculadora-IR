import React, {useState, useEffect} from "react";
import Calculadora from "./components/Calculadora";
import Historico from "./components/Historico";
import Login from "./components/Login";

function App() {
  const [autenticado, setAutenticado] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem("token");
    setAutenticado(!!token);
  }, []);

  const logout = () => {
    localStorage.removeItem("token");
    setAutenticado(false);
  };

  if(!autenticado) return <Login onLogin={() => setAutenticado(true)} />;

  return (
    <div className = "App">
      <button onClick={logout} style={{float: "right"}}>Sair</button>
      <Calculadora />
      <Historico  />
    </div>
  );
}

export default App
import React from 'react';
import './App.css';
import { Counter } from './features/counter';
import Header from './components/Header';
import Home from "./components/Home";
import Section from "./components/Section";

function App() {
  return (
    <div className="App">
      <Header />
      <Home />
    </div>
  );
}

export default App;

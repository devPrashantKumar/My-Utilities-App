import { Routes, Route } from 'react-router-dom'
import Topbar from './components/Topbar'
import Home from './pages/Home'
import JsonFormatter from './pages/JsonFormatter'
import JsonCompare from './pages/JsonCompare'
import JsonToPojo from './pages/JsonToPojo'
import Portfolio from './pages/Portfolio'

export default function App() {
  return (
    <div className="app">
      <Topbar />
      <main className="main-content">
        <Routes>
          <Route path="/"               element={<Home />} />
          <Route path="/json-formatter" element={<JsonFormatter />} />
          <Route path="/json-compare"   element={<JsonCompare />} />
          <Route path="/json-to-pojo"   element={<JsonToPojo />} />
          <Route path="/portfolio"      element={<Portfolio />} />
        </Routes>
      </main>
    </div>
  )
}
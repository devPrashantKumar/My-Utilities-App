import { useNavigate } from 'react-router-dom'

export default function ToolCard({ icon, title, desc, tag, path, featured }) {
  const navigate = useNavigate()

  return (
    <div
      className={`tool-card ${featured ? 'featured' : ''}`}
      onClick={() => navigate(path)}
    >
      <div className="tool-icon">{icon}</div>
      <div className="tool-name">{title}</div>
      <div className="tool-desc">{desc}</div>
      {tag && <span className="tool-tag">{tag}</span>}
    </div>
  )
}
import { useLocation, useNavigate } from 'react-router-dom'

const NAV_LINKS = [
  { label: 'Tools',     path: '/' },
  { label: 'Portfolio', path: '/portfolio' },
]

export default function Topbar() {
  const { pathname } = useLocation()
  const navigate = useNavigate()

  return (
    <header className="topbar">
      <div className="logo" onClick={() => navigate('/')}>
        <div className="logo-icon">D</div>
        DevKit
      </div>
      <nav className="nav-links">
        {NAV_LINKS.map(link => (
          <button
            key={link.path}
            className={`nav-btn ${pathname === link.path ? 'active' : ''}`}
            onClick={() => navigate(link.path)}
          >
            {link.label}
          </button>
        ))}
      </nav>
    </header>
  )
}
import ToolCard from '../components/ToolCard'

const TOOLS = [
  {
    icon: '{ }',
    title: 'JSON formatter',
    desc: 'Beautify, minify and validate JSON with syntax highlighting',
    tag: 'Most used',
    path: '/json-formatter',
    featured: true,
  },
  {
    icon: '⇄',
    title: 'JSON compare',
    desc: 'Diff two JSON objects and highlight added, removed, and changed fields',
    tag: 'Diff',
    path: '/json-compare',
  },
  {
    icon: '⬡',
    title: 'JSON → POJO',
    desc: 'Generate Java classes from any JSON with Lombok support',
    tag: 'Generate',
    path: '/json-to-pojo',
  },
]

export default function Home() {
  return (
    <div className="page">
      <div className="hero">
        <div className="hero-tag">Developer utility suite</div>
        <h1 className="hero-title">Your personal dev toolkit</h1>
        <p className="hero-sub">
          Parse, convert, compare, and validate JSON.
          All tools run instantly in your browser.
        </p>
      </div>
      <div className="section-label">All tools</div>
      <div className="tools-grid">
        {TOOLS.map(tool => (
          <ToolCard key={tool.path} {...tool} />
        ))}
      </div>
    </div>
  )
}
import { useState } from 'react'
import Editor from '@monaco-editor/react'
import WorkspacePane from '../components/WorkspacePane'

export default function JsonFormatter() {
  const [input, setInput]   = useState('')
  const [output, setOutput] = useState('')
  const [error, setError]   = useState(null)
  const [minified, setMinified] = useState(false)

  const format = () => {
    try {
      const parsed = JSON.parse(input)
      setOutput(
        minified
          ? JSON.stringify(parsed)
          : JSON.stringify(parsed, null, 2)
      )
      setError(null)
    } catch (e) {
      setError(e.message)
      setOutput('')
    }
  }

  const copyOutput = () => {
    if (output) navigator.clipboard.writeText(output)
  }

  return (
    <div className="page">
      <WorkspacePane
        title="JSON formatter"
        leftLabel="Input JSON"
        rightLabel={error ? 'Error' : 'Output'}
        leftContent={
          <Editor
            height="420px"
            language="json"
            value={input}
            onChange={val => setInput(val || '')}
            options={{ minimap: { enabled: false }, fontSize: 13 }}
          />
        }
        rightContent={
          error ? (
            <div className="error-box">{error}</div>
          ) : (
            <Editor
              height="420px"
              language="json"
              value={output}
              options={{ readOnly: true, minimap: { enabled: false }, fontSize: 13 }}
            />
          )
        }
        footer={
          <div className="ws-footer-inner">
            <label className="toggle-label">
              <input
                type="checkbox"
                checked={minified}
                onChange={e => setMinified(e.target.checked)}
              />
              Minify
            </label>
            <div className="footer-actions">
              <button className="ws-btn" onClick={copyOutput}>Copy</button>
              <button className="ws-btn primary" onClick={format}>Format</button>
            </div>
          </div>
        }
      />
    </div>
  )
}
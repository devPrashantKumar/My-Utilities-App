import { useState } from 'react'
import Editor from '@monaco-editor/react'
import { jsonApi } from '../services/api'

export default function JsonToPojo() {
  const [input, setInput]       = useState('')
  const [output, setOutput]     = useState('')
  const [className, setClassName] = useState('MyClass')
  const [useLombok, setUseLombok] = useState(true)
  const [loading, setLoading]   = useState(false)
  const [error, setError]       = useState(null)

  const generate = async () => {
    try {
      setLoading(true)
      setError(null)
      const res = await jsonApi.toPojo(input, { className, useLombok })
      setOutput(res.data.code)
    } catch (e) {
      setError(e.response?.data?.message || e.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="page">
      <div className="pojo-options">
        <input
          className="text-input"
          placeholder="Class name"
          value={className}
          onChange={e => setClassName(e.target.value)}
        />
        <label className="toggle-label">
          <input
            type="checkbox"
            checked={useLombok}
            onChange={e => setUseLombok(e.target.checked)}
          />
          Lombok
        </label>
        <button className="ws-btn primary" onClick={generate} disabled={loading}>
          {loading ? 'Generating...' : 'Generate POJO'}
        </button>
      </div>
      <div className="compare-grid">
        <div className="compare-pane">
          <div className="pane-label">JSON input</div>
          <Editor height="420px" language="json"
            value={input} onChange={v => setInput(v || '')}
            options={{ minimap: { enabled: false }, fontSize: 13 }} />
        </div>
        <div className="compare-pane">
          <div className="pane-label">Java class</div>
          {error
            ? <div className="error-box">{error}</div>
            : <Editor height="420px" language="java"
                value={output}
                options={{ readOnly: true, minimap: { enabled: false }, fontSize: 13 }} />
          }
        </div>
      </div>
    </div>
  )
}
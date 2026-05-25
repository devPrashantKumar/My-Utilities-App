import { useState } from 'react'
import Editor from '@monaco-editor/react'
import * as deepDiff from 'deep-diff'

export default function JsonCompare() {
  const [left, setLeft]   = useState('')
  const [right, setRight] = useState('')
  const [diffs, setDiffs] = useState(null)
  const [error, setError] = useState(null)

  const compare = () => {
    try {
      const a = JSON.parse(left)
      const b = JSON.parse(right)
      const result = deepDiff.diff(a, b) || []
      setDiffs(result)
      setError(null)
    } catch (e) {
      setError(e.message)
      setDiffs(null)
    }
  }

  const kindLabel = {
    N: { label: 'Added',   color: '#0F6E56', bg: '#E1F5EE' },
    D: { label: 'Removed', color: '#712B13', bg: '#FAECE7' },
    E: { label: 'Changed', color: '#854F0B', bg: '#FAEEDA' },
    A: { label: 'Array',   color: '#185FA5', bg: '#E6F1FB' },
  }

  return (
    <div className="page">
      <div className="compare-grid">
        <div className="compare-pane">
          <div className="pane-label">Original</div>
          <Editor
            height="380px"
            language="json"
            value={left}
            onChange={v => setLeft(v || '')}
            options={{ minimap: { enabled: false }, fontSize: 13 }}
          />
        </div>
        <div className="compare-pane">
          <div className="pane-label">Modified</div>
          <Editor
            height="380px"
            language="json"
            value={right}
            onChange={v => setRight(v || '')}
            options={{ minimap: { enabled: false }, fontSize: 13 }}
          />
        </div>
      </div>

      <div className="compare-actions">
        <button className="ws-btn primary" onClick={compare}>Compare</button>
      </div>

      {error && <div className="error-box">{error}</div>}

      {diffs !== null && (
        <div className="diff-results">
          <div className="pane-label">{diffs.length} change{diffs.length !== 1 ? 's' : ''} found</div>
          {diffs.length === 0 ? (
            <div className="no-diff">JSON objects are identical</div>
          ) : (
            diffs.map((d, i) => {
              const k = kindLabel[d.kind] || kindLabel['E']
              return (
                <div key={i} className="diff-item" style={{ borderLeftColor: k.color }}>
                  <span className="diff-badge" style={{ background: k.bg, color: k.color }}>
                    {k.label}
                  </span>
                  <span className="diff-path">{(d.path || []).join('.')}</span>
                  {d.lhs !== undefined && (
                    <span className="diff-val old">{JSON.stringify(d.lhs)}</span>
                  )}
                  {d.rhs !== undefined && (
                    <span className="diff-val new">{JSON.stringify(d.rhs)}</span>
                  )}
                </div>
              )
            })
          )}
        </div>
      )}
    </div>
  )
}
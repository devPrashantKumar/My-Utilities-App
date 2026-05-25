export default function WorkspacePane({
  title,
  leftLabel = 'Input',
  rightLabel = 'Output',
  leftContent,
  rightContent,
  footer,
}) {
  return (
    <div className="workspace">
      {title && (
        <div className="ws-header">
          <span className="ws-title">{title}</span>
        </div>
      )}
      <div className="ws-body">
        <div className="ws-pane">
          <div className="pane-label">{leftLabel}</div>
          <div className="pane-content">{leftContent}</div>
        </div>
        <div className="ws-pane">
          <div className="pane-label">{rightLabel}</div>
          <div className="pane-content">{rightContent}</div>
        </div>
      </div>
      {footer && <div className="ws-footer">{footer}</div>}
    </div>
  )
}
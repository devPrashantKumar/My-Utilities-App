export function useLocalHistory(toolKey) {
  const storageKey = `devkit:history:${toolKey}`

  const getHistory = () =>
    JSON.parse(localStorage.getItem(storageKey) || '[]')

  const addEntry = (entry) => {
    const history = getHistory()
    const updated = [
      { ...entry, timestamp: Date.now() },
      ...history,
    ].slice(0, 20)
    localStorage.setItem(storageKey, JSON.stringify(updated))
  }

  const clearHistory = () => localStorage.removeItem(storageKey)

  return { getHistory, addEntry, clearHistory }
}
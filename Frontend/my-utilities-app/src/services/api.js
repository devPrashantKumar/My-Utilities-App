import axios from 'axios'

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL || 'http://localhost:8080/utilities-api',
  headers: { 'Content-Type': 'application/json' },
})

export const jsonApi = {
  format:  (json)        => api.post('/json/format',  { json }),
  compare: (a, b)        => api.post('/json/compare', { original: a, modified: b }),
  toPojo:  (json, opts)  => api.post('/json/to-pojo', { json, ...opts }),
}

export default api
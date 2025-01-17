import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import Nota from './pages/Nota';


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Nota/>
  </StrictMode>,
)

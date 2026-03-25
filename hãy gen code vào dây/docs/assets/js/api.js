const API_BASE_URL = "http://localhost:8080";

async function apiRequest(path, { method = "GET", body } = {}) {
  const url = `${API_BASE_URL}${path}`;
  const headers = {};
  if (body !== undefined) {
    headers["Content-Type"] = "application/json";
  }

  const res = await fetch(url, {
    method,
    headers,
    body: body !== undefined ? JSON.stringify(body) : undefined,
  });

  // Try parse JSON error payloads from GlobalExceptionHandler
  let payload = null;
  try {
    payload = await res.json();
  } catch (_) {
    // ignore
  }

  if (!res.ok) {
    const msg = payload?.message || `Request failed: ${res.status}`;
    throw new Error(msg);
  }
  return payload;
}

function getSession() {
  const raw = localStorage.getItem("session");
  if (!raw) return null;
  try {
    return JSON.parse(raw);
  } catch {
    return null;
  }
}

function setSession(data) {
  localStorage.setItem("session", JSON.stringify(data));
}

function clearSession() {
  localStorage.removeItem("session");
}


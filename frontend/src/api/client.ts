const API=import.meta.env.VITE_API_URL??"http://localhost:8080";
export async function api<T>(path:string,init:RequestInit={}):Promise<T>{const r=await fetch(API+path,{...init,credentials:"include",headers:{"Content-Type":"application/json",...(init.headers??{})}});if(!r.ok)throw new Error(await r.text()||r.statusText);if(r.status===204)return undefined as T;return r.json();}

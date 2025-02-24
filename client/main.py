import os
from fastapi import FastAPI, Depends, Request
from fastapi.responses import RedirectResponse
from authlib.integrations.starlette_client import OAuth
from starlette.middleware.sessions import SessionMiddleware
from dotenv import load_dotenv

load_dotenv()

app = FastAPI()

# Add session middleware
app.add_middleware(SessionMiddleware, secret_key="your_secret_key", session_cookie="oidc_session")

# OAuth Configuration
oauth = OAuth()

oauth.register(
    name="oidc",
    # client_id=os.getenv("OIDC_CLIENT_ID"),
    client_id="local-client",
    # client_secret=os.getenv("OIDC_CLIENT_SECRET"),
    client_secret="foo",
    server_metadata_url=f"https://idp-dev.kevharv.com/.well-known/openid-configuration",
    client_kwargs={"scope": "openid profile"},
)

@app.get("/")
async def home(request: Request):
    user = request.session.get("user")
    if user:
        return {"message": "Authenticated", "user": user}
    return RedirectResponse(url="/login")

@app.get("/login")
async def login(request: Request):
    redirect_uri = request.url_for("auth")
    return await oauth.oidc.authorize_redirect(request, redirect_uri)

@app.get("/auth")
async def auth(request: Request):
    print(request)
    token = await oauth.oidc.authorize_access_token(request)
    user = await oauth.oidc.parse_id_token(request, token)
    
    # Store user in session
    request.session["user"] = user
    return RedirectResponse(url="/")

@app.get("/logout")
async def logout(request: Request):
    request.session.clear()
    return RedirectResponse(url="/")


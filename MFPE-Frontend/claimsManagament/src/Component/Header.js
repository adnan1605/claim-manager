import React from "react";
import { Navigate } from "react-router-dom";
import pic1 from "./assets/img/aurora-dao.svg";
import { useNavigate } from 'react-router-dom';
import Login from "./ClaimStatus";


const loginHandle = () =>{
  navigate("/Login.js")
}
function Header(){
    return(



    <div class="header">
    <nav
      className="nav navbar navbar-expand-lg navbar-light bg-light navbar-fixed-top"
    >
      <a class="navbar-brand" routerLink="home"
        ><img
          src={pic1}
          class="brand-logo"
          alt="brand logo"
        />MediClaim</a
      >
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav nav-items">
          <li class="nav-item" routerLinkActive="active">
            <a class="nav-link" routerLink="home">Home</a>
          </li>
          <li class="nav-item" routerLinkActive="active">
            <a class="nav-link" onClick={{loginHandle}}>Login</a>
          </li>
          </ul>
          </div>
          </nav>
  
          {/* <div class="dropdown" routerLinkActive="active" *ngIf="isAuthenticated">
            <div class="projects">
              <button class="nav-link">
                <img
                  src="../../assets/img/user.png"
                  alt="user icon"
                  class="user-icon"
                />{{ username }}
              </button>
              <ul>
                <li [routerLink]="[username, 'viewClaims']"><a>View Bills</a></li>
                <li [routerLink]="[username, 'getClaimStatus']">
                  <a>View Claim Status</a>
                </li>
                <li [routerLink]="[username, 'submitClaim']">
                  <a>Submit Claim</a>
                </li>
                <li (click)="onLogout()"><a>Logout</a></li>
              </ul>
            </div>
          </div>
        </ul>
      </div>
    </nav>
  </div> */}

  </div>

  );



}
export default Header;
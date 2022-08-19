import React from 'react'
import { Link } from 'react-router-dom'

export default function NavBar() {
    return (
        <nav className="navbar navbar-dark bg-dark">
          <Link to="/">
          <a className ="navbar-brand mx-auto" href="#"> Welcome to Claims Management</a>
          </Link>

        </nav>

    )
}

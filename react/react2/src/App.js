import {useEffect, useState} from "react";
import Nav from "./Nav";
import { BrowserRouter } from "react-router-dom"

function App() {
    const [list, setList] = useState([]);

    return (
        <BrowserRouter>
          <Nav/>
            
        </BrowserRouter>
    );
}

export default App;
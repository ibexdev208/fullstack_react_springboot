//Imports
import React from 'react';
import { Route, Switch, Link } from 'react-router-dom';

//Components
import Home from './Home';
import Monitors from './Monitors';
import AddMonitor from './AddMonitor';

class Header extends React.Component {
   constructor({title}) {
       super(title);
       this.state = {
           title: "iBex Monitors"
       }
   }
    render() {
        return ( 
            <>
                <div className="banner">
                    <div id="h1">
                        <span>{this.state.title}</span>
                    </div>
                    <div className="brand">
                        <span id="logo"><Link to='/'>BS</Link></span>
                    </div>
                </div>
                <nav>
                    <ul>
                    <li><Link to='/monitors'>Monitors</Link></li>
                    <li><Link to='/addMonitor/_add'>Add New Monitor</Link></li>
                    </ul>
                </nav>
                <Switch>
                    <Route path='/' exact component={Home}></Route>
                    <Route path='/monitors' component={Monitors}></Route>
                    {/* Step 1 */}
                    <Route path='/addMonitor/:id' component={AddMonitor}></Route>
                </Switch>
            </>
        );
    }
}

export default Header

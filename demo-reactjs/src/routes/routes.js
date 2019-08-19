import React from 'react';

import { BrowserRouter, Route, Switch } from 'react-router-dom';

import PrivateRoute from '../services/PrivateRoute';

import Login from '../pages/login';
import Main from '../pages/main';

 const Routes = () => (
    <BrowserRouter>
        <Switch>
            <Route path='/login' exact component={Login}/>
            <PrivateRoute path='/main' exact component={Main} />
        </Switch>
    </BrowserRouter>
 )

export default Routes;
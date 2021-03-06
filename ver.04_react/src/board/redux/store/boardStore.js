import { createStore, combineReducers, applyMiddleware } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import thunk from 'redux-thunk';

import reducers from '../reduce';

export default (initStates) =>
  createStore(combineReducers(reducers), initStates, composeWithDevTools(applyMiddleware(thunk)));

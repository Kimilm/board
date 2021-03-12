import React, { Component } from 'react';
import { Provider } from 'react-redux';
import { Container, CssBaseline } from '@material-ui/core';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import boardStore from './redux/store/boardStore';
import Layout from './component/Layout';
import PostListContainer from './container/main/PostListContainer';
import PostContainer from './container/main/PostContainer';

class App extends Component {
  store = boardStore();
  render() {
    return (
      <React.Fragment>
        <Router>
          <Provider store={this.store}>
            <CssBaseline />
            <Container maxWidth="lg">
              <Layout>
                <Switch>
                  {/* <Route path="/" exact render={() => <PostListContainer />} /> */}
                  <Route path="/" exact component={PostListContainer} />
                  {/* <Route path="/post/:postNo" exact render={() => <PostContainer />} /> */}
                  <Route path="/post/:postNo" exact component={PostContainer} />
                </Switch>
              </Layout>
            </Container>
          </Provider>
        </Router>
      </React.Fragment>
    );
  }
}

export default App;

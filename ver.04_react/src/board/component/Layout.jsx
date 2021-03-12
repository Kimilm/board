import React, { PureComponent } from 'react';
import TopBar from './TopBar';
import PropTypes from 'prop-types';

class Layout extends PureComponent {
  render() {
    const { children } = this.props;
    return (
      <div>
        <TopBar />
        <div>{children}</div>
      </div>
    );
  }
}

Layout.propTypes = {
  children: PropTypes.node,
};

export default Layout;

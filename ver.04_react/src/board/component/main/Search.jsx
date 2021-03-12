import React, { PureComponent } from 'react';
import { Button, TextField, Box } from '@material-ui/core';
import PropTypes from 'prop-types';

class search extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {
      value: '',
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleChange(e) {
    this.setState({ value: e.target.value });
  }

  handleSubmit(e) {
    const { value } = this.state;
    e.preventDefault();

    console.log(value);

    // const { history } = this.props;
    // const cleanedParams = Object.entries(value)
    //   .filter(([key, value]) => value !== '')
    //   .reduce((obj, [key, value]) => ({ ...obj, [key]: value }), {});
    // const querystring = Object.entries(cleanedParams)
    //   .map(([key, value]) => `${key}=${value}`)
    //   .join('&');
    //history.push(`/?${querystring}`);

    let cleanedParams = {
      ['postTitle_like']: value,
    };

    if (value === '') {
      cleanedParams = {};
    }

    const { requestPostList, setFilter } = this.props;
    setFilter(cleanedParams);
    requestPostList(cleanedParams);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <Box display="flex" alignItems="center">
          <TextField
            id="search"
            size="small"
            name="postTitle_like"
            variant="outlined"
            value={this.state.value}
            onChange={this.handleChange}
          />
          &nbsp;&nbsp;
          <Button ml={2} variant="contained" type="submit" color="primary">
            검색
          </Button>
        </Box>
      </form>
    );
  }
}

search.propTypes = { requestPostList: PropTypes.func, setFilter: PropTypes.func };

export default search;

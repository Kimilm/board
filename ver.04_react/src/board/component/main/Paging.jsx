import { Button } from '@material-ui/core';
import React, { PureComponent } from 'react';

class Paging extends PureComponent {
  constructor(props) {
    super(props);
    this.handleNextPress = this.handleNextPress.bind(this);
    this.handlePrevPress = this.handlePrevPress.bind(this);
  }
  handlePrevPress() {
    const { resetPostList, requestPostList, pageNumber, searchParams } = this.props;
    resetPostList();
    requestPostList(searchParams, pageNumber - 1);
  }

  handleNextPress() {
    const { resetPostList, requestPostList, pageNumber, searchParams } = this.props;
    resetPostList();
    requestPostList(searchParams, pageNumber + 1);
  }

  render() {
    const { pageNumber, hasNext } = this.props;
    const prevDisabled = pageNumber <= 1;
    const nextDisabled = !hasNext;

    return (
      <div>
        <Button variant="contained" disabled={prevDisabled} onClick={this.handlePrevPress}>
          이전
        </Button>
        &nbsp;&nbsp;
        <Button
          variant="contained"
          color="primary"
          disabled={nextDisabled}
          onClick={this.handleNextPress}
        >
          다음
        </Button>
      </div>
    );
  }
}

Paging.propTypes = {};

export default Paging;

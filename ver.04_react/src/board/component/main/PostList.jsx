import React, { PureComponent } from 'react';
import PostTable from './PostTable';
import { Box } from '@material-ui/core';
import SearchContainer from '../../container/main/SearchContainer';
import PagingContainer from '../../container/main/PagingContainer';

class PostList extends PureComponent {
  componentDidMount() {
    this.props.resetPostList();
    this.props.requestPostList();
  }

  render() {
    const { posts } = this.props;

    return (
      <div>
        <Box mt={3} mb={2}>
          <PostTable posts={posts} />
        </Box>
        <Box display="flex" justifyContent="space-between" alignItems="center">
          <SearchContainer />
          <PagingContainer />
        </Box>
      </div>
    );
  }
}

PostList.defaultProps = {
  posts: [],
  resetPostList: () => {},
  requestPostList: () => {},
};

export default PostList;

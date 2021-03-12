import React, { PureComponent } from 'react';
import { Box } from '@material-ui/core';
import Content from './Content';
import Comment from './Comment';

class Post extends PureComponent {
  componentDidMount() {
    const { params } = this.props.match;
    this.props.resetPost();
    this.props.resetComment();
    this.props.requestPost(params.postNo);
    this.props.requestComment(params.postNo);
  }

  render() {
    const { post } = this.props;
    const { comments } = this.props;
    return (
      <div>
        <Box mt={3} mb={2} p={4} bgcolor="white" boxShadow={2}>
          <Content post={post} />
        </Box>
        <Comment comments={comments} />
      </div>
    );
  }
}

Post.defaultProps = {
  post: [],
  commments: [],
  resetPost: () => {},
  requestPost: () => {},
  resetComment: () => {},
  requestComment: () => {},
};

export default Post;

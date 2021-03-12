import { Box, Paper, Typography } from '@material-ui/core';
import React, { PureComponent } from 'react';

class Comment extends PureComponent {
  render() {
    const { comments } = this.props;

    return (
      <div>
        {comments.map(({ commentNo, commentContent, commentDate, user }) => (
          <Box mb={1} p={2} bgcolor="white" boxShadow={2}>
            <input type="hidden" value={commentNo} />
            <Typography variant="body1" gutterBottom>
              {commentContent}
            </Typography>
            <Typography align="right" variant="caption" gutterBottom>
              {commentDate} / {user.userId}
            </Typography>
          </Box>
        ))}
      </div>
    );
  }
}

Comment.defaultProps = {
  comments: [],
};

export default Comment;

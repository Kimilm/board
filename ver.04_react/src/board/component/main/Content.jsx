import { Typography } from '@material-ui/core';
import React, { PureComponent } from 'react';

class Content extends PureComponent {
  render() {
    const { post } = this.props;
    return (
      <div>
        {post.map(({ postNo, postTitle, postContent, postDate, user }) => (
          <div>
            <input type="hidden" value={postNo} />
            <Typography variant="h2" align="center" gutterBottom>
              {postTitle}
            </Typography>
            <Typography align="right" gutterBottom>
              {postDate}/ {user.userId}
            </Typography>
            <br />
            <br />
            <Typography variant="h5" gutterBottom>
              {postContent}
            </Typography>
          </div>
        ))}
      </div>
    );
  }
}

Content.defaultProps = {
  post: [],
};

export default Content;

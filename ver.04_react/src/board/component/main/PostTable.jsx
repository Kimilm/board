import React, { PureComponent } from 'react';
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from '@material-ui/core';
import { Link } from 'react-router-dom';

class PostTable extends PureComponent {
  render() {
    const { posts } = this.props;

    return (
      <TableContainer component={Paper}>
        <Table aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>작성자</TableCell>
              <TableCell align="center">제목</TableCell>
              <TableCell align="right">작성일</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {posts.map(({ postNo, user, postTitle, postDate }) => (
              <TableRow
                key={postNo}
                component={Link}
                to={`/post/${postNo}/`}
                style={{ textDecoration: 'none' }}
              >
                <TableCell>{user.userId}</TableCell>
                <TableCell align="center">{postTitle}</TableCell>
                <TableCell align="right">{postDate}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    );
  }
}

PostTable.defaultProps = {
  posts: [],
};

export default PostTable;

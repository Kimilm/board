import React from 'react';
import { makeStyles, AppBar, Toolbar, Typography, Button } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
  },
}));

export default function ButtonAppBar() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" className={classes.title}>
            <a href="/" style={{ textDecoration: 'none', color: 'white' }}>
              Board
            </a>
          </Typography>
          <Button color="inherit">로그인</Button>
          <Button color="inherit">회원가입</Button>
        </Toolbar>
      </AppBar>
    </div>
  );
}

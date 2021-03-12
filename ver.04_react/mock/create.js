const getRandomNumber = (min, max) => {
  const range = max - min + 1;
  return parseInt(Math.random() * range + min, 10);
};

function createUser() {
  let users = [];

  for (let i = 0; i < 4; ++i) {
    let user = {
      userNo: i,
      userId: `user${i}`,
      userName: `user${i}`,
      userPassword: `user${i}`,
      userEmail: `user${i}@someMail.com`,
    };
    users.push(user);
  }

  return users;
}

const createComment = (index) => {
  const randomUser = getRandomNumber(0, 3);
  return {
    commentNo: index,
    commentDate: '2021/03/04 08:23:22',
    commentContent: `TestContent${index}`,
    postNo: 149,
    user: {
      userNo: randomUser,
      userId: users[randomUser].userId,
    },
  };
};

const createData = (index) => {
  const randomUser = getRandomNumber(0, 3);
  return {
    postNo: index,
    postDate: '2021/03/04 08:23:22',
    postTitle: `TestTitle${index}`,
    postContent: `TestContent${index}`,
    user: {
      userNo: randomUser,
      userId: users[randomUser].userId,
    },
  };
};

const users = createUser();

module.exports = function () {
  return {
    users: users,
    posts: Array(150)
      .fill('')
      .map((_, index) => createData(index)),
    comments: Array(5)
      .fill('')
      .map((_, index) => createComment(index)),
  };
};

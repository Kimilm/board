import { RESET_POST_LIST, SET_POST_LIST } from '../action/postListAction';

const initState = {
  posts: [],
  pagination: {},
};

export default function reducer(state = initState, action) {
  const { type, payload, meta } = action;
  switch (type) {
    case SET_POST_LIST: {
      const posts = payload;
      return {
        ...state,
        posts,
        pagination: {
          number: meta._page,
          size: 10,
        },
      };
    }
    case RESET_POST_LIST: {
      return initState;
    }
    default:
      return state;
  }
}

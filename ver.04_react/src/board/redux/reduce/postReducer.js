import { RESET_POST, SET_POST } from '../action/postAction';

const initState = {
  post: [],
};

export default function reducer(state = initState, action) {
  const { type, payload } = action;
  switch (type) {
    case SET_POST: {
      const post = payload;
      return { ...state, post };
    }
    case RESET_POST: {
      return initState;
    }
    default:
      return state;
  }
}

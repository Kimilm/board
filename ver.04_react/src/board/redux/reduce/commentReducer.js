import { RESET_COMMENT, SET_COMMENT } from '../action/commentAction';

const initState = {
  comments: [],
};

export default function reducer(state = initState, action) {
  const { type, payload } = action;
  switch (type) {
    case SET_COMMENT: {
      const comments = payload;
      return { ...state, comments };
    }
    case RESET_COMMENT: {
      return initState;
    }
    default:
      return state;
  }
}

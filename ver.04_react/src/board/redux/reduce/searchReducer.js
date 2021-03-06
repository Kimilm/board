import { SET_FILTER } from '../action/searchAction';

const initState = {
  params: {},
};

export default (state = initState, action) => {
  const { type, payload } = action;

  switch (type) {
    case SET_FILTER: {
      const { params } = payload;
      return { ...state, params };
    }

    default:
      return state;
  }
};

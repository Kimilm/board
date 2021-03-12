import Api from '../../Api/Api';

export const SET_POST_LIST = 'posts/SET_POST_LIST';
export const RESET_POST_LIST = 'posts/RESET_POST_LIST';

export function resetPostList() {
  return {
    type: RESET_POST_LIST,
  };
}

const PAGE_SIZE = 10;

export function setPostList(posts, _page) {
  return {
    type: SET_POST_LIST,
    payload: posts,
    meta: {
      _page,
    },
  };
}

export function requestPostList(param, _page = 1) {
  return (dispatch) =>
    Api.get('/posts', {
      params: {
        ...param,
        _page,
        _limit: PAGE_SIZE,
        _sort: 'postNo',
        _order: 'desc',
      },
    }).then(({ data }) => dispatch(setPostList(data, _page)));
}

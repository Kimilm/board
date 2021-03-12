import Api from '../../Api/Api';

export const SET_POST = 'post/SET_POST';
export const RESET_POST = 'post/RESET_POST';

export function resetPost() {
  return {
    type: RESET_POST,
  };
}

export function setPost(post) {
  return {
    type: SET_POST,
    payload: post,
  };
}

export function requestPost(postNo = 0, params = {}) {
  return (dispatch) =>
    Api.get(`/posts?postNo=${postNo}`, {
      params,
    }).then(({ data }) => dispatch(setPost(data)));
}

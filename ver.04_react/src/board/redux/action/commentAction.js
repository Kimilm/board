import Api from '../../Api/Api';

export const SET_COMMENT = 'comments/SET_COMMENT';
export const RESET_COMMENT = 'comments/RESET_COMMENT';

export function resetComment() {
  return {
    type: RESET_COMMENT,
  };
}

export function setComment(comments) {
  return {
    type: SET_COMMENT,
    payload: comments,
  };
}

export function requestComment(postNo = 0, params = {}) {
  return (dispatch) =>
    Api.get(`/comments?postNo=${postNo}`, {
      params,
    }).then(({ data }) => dispatch(setComment(data)));
}

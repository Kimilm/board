import { connect } from 'react-redux';
import Post from '../../component/main/Post';
import { resetPost, requestPost } from '../../redux/action/postAction';
import { resetComment, requestComment } from '../../redux/action/commentAction';

const mapStateToProps = (state, props) => {
  const { post } = state.post;
  const { comments } = state.comments;
  return { ...props, post, comments };
};

const mapDispatchToProps = {
  resetPost,
  requestPost,
  resetComment,
  requestComment,
};

export default connect(mapStateToProps, mapDispatchToProps)(Post);

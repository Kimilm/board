import { connect } from 'react-redux';
import Search from '../../component/main/Search';
import { requestPostList } from '../../redux/action/postListAction';
import { setFilter } from '../../redux/action/searchAction';

const mapStateToProps = (state, props) => ({
  initValues: state.search.params,
  ...props,
});

const mapDispatchToProps = {
  setFilter,
  requestPostList,
};

export default connect(mapStateToProps, mapDispatchToProps)(Search);

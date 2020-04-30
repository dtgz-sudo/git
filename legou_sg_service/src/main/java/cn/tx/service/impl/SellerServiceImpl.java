package cn.tx.service.impl;

import cn.tx.domain.TbSeller;
import cn.tx.domain.TbSellerExample;
import cn.tx.mapper.TbSellerMapper;
import cn.tx.service.SellerService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Transactional
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private TbSellerMapper sellerMapper;

	/**
	 * 查询所有
	 *
	 * @return
	 */
	@Override
	public List<TbSeller> findAll() {
		return sellerMapper.selectByExample(null);
	}

	/**
	 * 分页查询
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public PageInfo<TbSeller> findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<TbSeller> list = sellerMapper.selectByExample(null);
		return new PageInfo<>(list);
	}

	/**
	 * 保存
	 *
	 * @param seller
	 */
	@Override
	public void add(TbSeller seller) {

		if ( seller.getSellerId() == null && seller.getSellerId().isEmpty() ) {
			new Exception("seller的名字不能为空");
		}
		sellerMapper.insert(seller);

	}

	/**
	 * 修改
	 *
	 * @param seller
	 */
	@Override
	public void update(TbSeller seller) {
		sellerMapper.updateByPrimaryKey(seller);
	}

	/**
	 * 通过主键查询
	 *
	 * @param id
	 * @return
	 */
	@Override
	public TbSeller findOne(String id) {
		return sellerMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			sellerMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 审核商家的状态
	 *
	 * @param sellerId
	 * @param status
	 */
	@Override
	public void auditing(String sellerId, String status) {

		// 查询到指定的商家 
		TbSeller tbSeller = sellerMapper.selectByPrimaryKey(sellerId);
		// 修改指定的状态
		tbSeller.setStatus(status);
		sellerMapper.updateByPrimaryKey(tbSeller);
	}

	/**
	 * 分页条件查询
	 *
	 * @param seller
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@Override
	public PageInfo<TbSeller> findPage(TbSeller seller, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbSellerExample example = new TbSellerExample();
		TbSellerExample.Criteria criteria = example.createCriteria();

		if ( seller != null ) {
			if ( seller.getSellerId() != null && seller.getSellerId().length() > 0 ) {
				criteria.andSellerIdLike("%" + seller.getSellerId() + "%");
			}
			if ( seller.getName() != null && seller.getName().length() > 0 ) {
				criteria.andNameLike("%" + seller.getName() + "%");
			}
			if ( seller.getNickName() != null && seller.getNickName().length() > 0 ) {
				criteria.andNickNameLike("%" + seller.getNickName() + "%");
			}
			if ( seller.getPassword() != null && seller.getPassword().length() > 0 ) {
				criteria.andPasswordLike("%" + seller.getPassword() + "%");
			}
			if ( seller.getEmail() != null && seller.getEmail().length() > 0 ) {
				criteria.andEmailLike("%" + seller.getEmail() + "%");
			}
			if ( seller.getMobile() != null && seller.getMobile().length() > 0 ) {
				criteria.andMobileLike("%" + seller.getMobile() + "%");
			}
			if ( seller.getTelephone() != null && seller.getTelephone().length() > 0 ) {
				criteria.andTelephoneLike("%" + seller.getTelephone() + "%");
			}
			if ( seller.getStatus() != null && seller.getStatus().length() > 0 ) {
				criteria.andStatusLike("%" + seller.getStatus() + "%");
			}
			if ( seller.getAddressDetail() != null && seller.getAddressDetail().length() > 0 ) {
				criteria.andAddressDetailLike("%" + seller.getAddressDetail() + "%");
			}
			if ( seller.getLinkmanName() != null && seller.getLinkmanName().length() > 0 ) {
				criteria.andLinkmanNameLike("%" + seller.getLinkmanName() + "%");
			}
			if ( seller.getLinkmanQq() != null && seller.getLinkmanQq().length() > 0 ) {
				criteria.andLinkmanQqLike("%" + seller.getLinkmanQq() + "%");
			}
			if ( seller.getLinkmanMobile() != null && seller.getLinkmanMobile().length() > 0 ) {
				criteria.andLinkmanMobileLike("%" + seller.getLinkmanMobile() + "%");
			}
			if ( seller.getLinkmanEmail() != null && seller.getLinkmanEmail().length() > 0 ) {
				criteria.andLinkmanEmailLike("%" + seller.getLinkmanEmail() + "%");
			}
			if ( seller.getLicenseNumber() != null && seller.getLicenseNumber().length() > 0 ) {
				criteria.andLicenseNumberLike("%" + seller.getLicenseNumber() + "%");
			}
			if ( seller.getTaxNumber() != null && seller.getTaxNumber().length() > 0 ) {
				criteria.andTaxNumberLike("%" + seller.getTaxNumber() + "%");
			}
			if ( seller.getOrgNumber() != null && seller.getOrgNumber().length() > 0 ) {
				criteria.andOrgNumberLike("%" + seller.getOrgNumber() + "%");
			}
			if ( seller.getLogoPic() != null && seller.getLogoPic().length() > 0 ) {
				criteria.andLogoPicLike("%" + seller.getLogoPic() + "%");
			}
			if ( seller.getBrief() != null && seller.getBrief().length() > 0 ) {
				criteria.andBriefLike("%" + seller.getBrief() + "%");
			}
			if ( seller.getLegalPerson() != null && seller.getLegalPerson().length() > 0 ) {
				criteria.andLegalPersonLike("%" + seller.getLegalPerson() + "%");
			}
			if ( seller.getLegalPersonCardId() != null && seller.getLegalPersonCardId().length() > 0 ) {
				criteria.andLegalPersonCardIdLike("%" + seller.getLegalPersonCardId() + "%");
			}
			if ( seller.getBankUser() != null && seller.getBankUser().length() > 0 ) {
				criteria.andBankUserLike("%" + seller.getBankUser() + "%");
			}
			if ( seller.getBankName() != null && seller.getBankName().length() > 0 ) {
				criteria.andBankNameLike("%" + seller.getBankName() + "%");
			}

		}
		// 查询数据
		List<TbSeller> list = sellerMapper.selectByExample(example);
		return new PageInfo<>(list);
	}

}

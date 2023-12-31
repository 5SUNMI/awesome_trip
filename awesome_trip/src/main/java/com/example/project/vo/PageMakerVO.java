package com.example.project.vo;

public class PageMakerVO {

	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private boolean prev, next; // 이전 페이지, 다음 페이지 존재 유무
	private int total; // 전체 게시물 수
	private int realEnd;; // 전체 시작 페이지 
	private int realStart; // 전체 끝 페이지
	private Criteria cri; // 현재 페이지, 페이지 당 게시물 표시 수 정보
	
	// 생성자
	public PageMakerVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// 마지막 페이지
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 5.0)) * 5;

		// 시작 페이지
		this.startPage = this.endPage - 4;

		// 전체 끝 페이지
		this.realStart = 1;
		
		// 전체 끝 페이지
		this.realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));

		// 전체 끝 페이지(realEnd)가 화면에 보이는 끝페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정
		if (this.realEnd < this.endPage) {
			this.endPage = this.realEnd;
		}
		// 시작 페이지(startPage)값이 1보다 큰 경우 true
		this.prev = this.startPage > 1;

		// 끝 페이지(endPage)값이 1보다 큰 경우 true
		this.next = this.endPage < this.realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public int getRealStart() {
		return realStart;
	}

	public void setRealStart(int realStart) {
		this.realStart = realStart;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMakerVO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", realEnd=" + realEnd + ", realStart=" + realStart + ", cri=" + cri + "]";
	}
	
}

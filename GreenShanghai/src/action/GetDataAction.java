package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Paste;
import service.PasteService;
import utils.PageBean;

import java.util.List;

//这个action是往Session域里传对象的
public class GetDataAction extends ActionSupport {

    private PasteService pasteService;
    private Integer currentPage;
    private Integer sb;

    public PasteService getPasteService() {
        return pasteService;
    }

    public void setPasteService(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    public String getData() throws Exception {

        PageBean pastePageBean= pasteService.getPastePageBean(currentPage);

        ActionContext.getContext().getSession().put("pastePageBean",pastePageBean);

        return "index";
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}

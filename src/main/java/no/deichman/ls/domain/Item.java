/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.deichman.ls.domain;


/**
 *
 * @author sbd
 */
public class Item {

    private int biblioItemNumber;
    private String holdingBranchName;
    private int notForLoan;
    private int itemNumber;
    private String itemCallNumber;
    private int itemLost;
    private long barcode;
    private String dateDue;
    private String uri;
    private String dateLastSeen;
    private String homeBranch;
    private String homeBranchName;
    private int manifestationId; // aka biblioNumber
    private String holdingBranch;
    private int copyNumber;

    public int getBiblioItemNumber() {
        return biblioItemNumber;
    }

    public void setBiblioItemNumber(int biblioItemNumber) {
        this.biblioItemNumber = biblioItemNumber;
    }

    public String getHoldingBranchName() {
        return holdingBranchName;
    }

    public void setHoldingBranchName(String holdingBranchName) {
        this.holdingBranchName = holdingBranchName;
    }

    public int getNotForLoan() {
        return notForLoan;
    }

    public void setNotForLoan(int notForLoan) {
        this.notForLoan = notForLoan;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemCallNumber() {
        return itemCallNumber;
    }

    public void setItemCallNumber(String itemCallNumber) {
        this.itemCallNumber = itemCallNumber;
    }

    public int getItemLost() {
        return itemLost;
    }

    public void setItemLost(int itemLost) {
        this.itemLost = itemLost;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getDateDue() {
        return dateDue;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDateLastSeen() {
        return dateLastSeen;
    }

    public void setDateLastSeen(String dateLastSeen) {
        this.dateLastSeen = dateLastSeen;
    }

    public String getHomeBranch() {
        return homeBranch;
    }

    public void setHomeBranch(String homeBranch) {
        this.homeBranch = homeBranch;
    }

    public String getHomeBranchName() {
        return homeBranchName;
    }

    public void setHomeBranchName(String homeBranchName) {
        this.homeBranchName = homeBranchName;
    }

    public int getManifestationId() {
        return manifestationId;
    }

    public void setManifestationId(int manifestationId) {
        this.manifestationId = manifestationId;
    }

    public String getHoldingBranch() {
        return holdingBranch;
    }

    public void setHoldingBranch(String holdingBranch) {
        this.holdingBranch = holdingBranch;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    
}

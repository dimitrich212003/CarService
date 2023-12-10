(() => {
    "use strict";
    function isWebp() {
        function testWebP(callback) {
            let webP = new Image;
            webP.onload = webP.onerror = function() {
                callback(webP.height == 2);
            };
            webP.src = "data:image/webp;base64,UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA";
        }
        testWebP((function(support) {
            let className = support === true ? "webp" : "no-webp";
            document.documentElement.classList.add(className);
        }));
    }
    let addWindowScrollEvent = false;
    setTimeout((() => {
        if (addWindowScrollEvent) {
            let windowScroll = new Event("windowScroll");
            window.addEventListener("scroll", (function(e) {
                document.dispatchEvent(windowScroll);
            }));
        }
    }), 0);
    function selectAunifRegist() {
        const auntif = document.getElementById("auntif");
        const regist = document.getElementById("regist");
        const auntForm = document.querySelector(".aunt");
        const regForm = document.querySelector(".reg");
        auntif.addEventListener("click", (() => {
            auntif.classList.add("bold");
            regist.classList.remove("bold");
            auntForm.classList.add("select");
            regForm.classList.remove("select");
        }));
        regist.addEventListener("click", (() => {
            regist.classList.add("bold");
            auntif.classList.remove("bold");
            regForm.classList.add("select");
            auntForm.classList.remove("select");
        }));
    }
    function starsPassword() {
        const password = document.querySelector("#password");
        const stringPass = password.textContent;
        password.textContent = "*".repeat(stringPass.length);
    }

    function updateLink() {
        document.getElementById("model").addEventListener("change", function() {
            const selectedModelId = document.getElementById("model").value;
            const link = document.getElementById("searchLink");
            link.href = "/offers/" + selectedModelId;
        });
    }

    function selectBrand() {
        const select = document.getElementById("brand");
        select.addEventListener("change", (event) => {
            localStorage.setItem("selectedBrand", event.target.value);
            if (window.location.pathname === "/") {
                window.location.href = "/?brandId=" + event.target.value;
            }
            else if (window.location.pathname === "/offer/add") {
                window.location.href = "/offer/add?brandId=" + event.target.value;
            }
        });
        const savedBrand = localStorage.getItem("selectedBrand");
        if (savedBrand) {
            select.value = savedBrand;
        }
    }
    if (window.location.pathname === "/" || window.location.pathname === "/offer/add") {
        selectBrand();
    }
    if (window.location.pathname === "/") {
        updateLink();
    }
    if (window.location.pathname === "/authorization") selectAunifRegist();
    if (window.location.pathname === "/profile") {
        starsPassword();
    }
    window["FLS"] = true;
    isWebp();
})();
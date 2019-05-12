$(document).ready(function() {
    Terminal.applyAddon(fit);

    var collapseBtn = document.getElementById("collapse-terminal");
    var termOverlay = document.getElementById("terminal-overlay");

    // charts
    function randomizeData(days) {
        var data = [];

        for (var i = 0; i < days; i++) {
            data.push({
                time: moment().add(i, "d"),
                connections: Math.floor(Math.random() * 100)
            });
        }

        return data;
    }

    var voiceData = randomizeData(10);
    var voiceLabels = [];
    var voiceSet = {
        label: "Music Connections",
        borderColor: "#fd6767",
        backgroundColor: "#ebebeb",
        fill: true,
        data: []
    };

    for (var data of voiceData) {
        voiceLabels.push(data.time.toDate());
        voiceSet.data.push(data.connections)
    }

    var voiceConnChart = new Chart(document.getElementById("voice-connection-chart").getContext("2d"), {
        type: "line",
        data: {
            datasets: [voiceSet],
            labels: voiceLabels
        },
        options: {
            scales: {
                xAxes: [
                    {
                        type: "time",
                        time: {
                            format: "MM/DD/YY HH:mm",
                            tooltipFormat: "ll HH:mm"
                        },
                        scaleLabel: {
                            display: false,
                            labelString: "Date"
                        }
                    }
                ],
            },
            elements: {
                line: {
                    tension: 0.000001
                }
            }
        }
    });

    var term = new Terminal();
    var termHidden = false;

    term.open(document.getElementById("terminal"));
    term.fit();

    window.onresize = function () {
        term.fit();
    };

    collapseBtn.onclick = function () {
        termHidden = !termHidden;

        if (!termHidden) {
            termOverlay.style.height = "248px";
            collapseBtn.children[0].classList.remove("fa-chevron-up");
            collapseBtn.children[0].classList.add("fa-chevron-down");
        } else {
            termOverlay.style.height = "48px";
            collapseBtn.children[0].classList.remove("fa-chevron-down");
            collapseBtn.children[0].classList.add("fa-chevron-up");
        }
    }

    term.write("yui@kyubey:~$ ")
});
